//Products.html
function addProduct(index) {
    var elems = $(".product" + index+"");
    var productName = elems[0].innerHTML;
    var orderProducts = $("strong.orderName");
    var exist = false;
    for (var i=0;i<orderProducts.length  && !exist;i++){
        if(productName===orderProducts[i].innerHTML){
            exist=true;
            var amount = parseInt($("span.amount:eq("+i+")").text()) + 1;
            $("span.amount:eq("+i+")").text(amount);
            $("input[name=amounts]:eq("+i+")").val(amount);           
        }
    }
    if(!exist){
    	var id = $(elems[0]).parent().find("input[type='hidden']").val();
        var row = $("<tr></tr>");
        row.html('<td><span class="glyphicon glyphicon-remove" aria-hidden="true" onclick="removeProduct(this);"></span></td>'
             +'<td><span class="amount">1</span><input name=amounts type="hidden" value="1"/></td>'
             +'<td><input name=products type="hidden" value="'+id+'"/><span>x</span></td>'
             +'<td><span class="product"><strong class="orderName">'+productName+'</strong></span></td>'
             +'<td><span class="price">'+elems[1].innerHTML+'</span> <span class="glyphicon glyphicon-euro"></span></td>');
        row.insertBefore($("#totalRow"));
    }
    
    calculateTotal();
}

function calculateTotal(){
    var amounts = $("span.amount");
    var prices = $("span.price");
    var total = 0;
    for(var i=0; i<amounts.length;i++){
        total = total + amounts[i].innerHTML * prices[i].innerHTML;
    }
    $("#totalID").text(total);
    $("input[name='total']").val(total);
}

function removeProduct(elem){
    var index = $(elem).parent().parent().index();
    var amount = parseInt($("span.amount:eq("+index+")").text());
    amount--;
    if(amount<1){
        $("#order tr:eq("+index+")").remove();
    }else{
        $("span.amount:eq("+index+")").text(amount);
    }
    calculateTotal();
}

//Form.html
function changeForm(){
    var userType = $("input[name='userType']:checked").val();
    if(userType==="person"){
        $(".surname").show();
        $(".categorias").hide();
        $(".image").hide();
    }else{
        $(".surname").hide();
        $(".categorias").show();
        $(".image").show();
    }
}

//listRequest.html
function deliver(elem){
	var index = $(elem).parent().parent().index();
	$("input[name='delivered']")[index].value=true;
	var spanDel = $($("span.delivered")[index]);
	spanDel.html("<strong> Entregado </strong>");
	spanDel.removeClass("text-warning");
	spanDel.addClass("text-primary");	
	elem.remove();
}

//editProducts.html
function deleteProdRest(elem){
    var index = $(elem).parent().parent().parent().index();
     $("#edit tr:eq("+(index+1)+")").remove();
}

function addProdRest(){
    var nomProd=$('#nombreItem').val();
    var precio=$('#precioItem').val();
    var descripcion=$('#descripcionItem').val();
    var row=$('<tr></tr>');
    
    $('table#edit').append(row);
    row.html('<td><div><button type="button" class="btn btn-danger btn-number btn-sm"  data-type="minus" data-field="quant[2]" onclick="deleteProdRest(this);"><span class="glyphicon glyphicon-remove"></span></button> '
             +'<button type="button" class="btn btn-warning btn-number btn-sm hidden" data-type="plus" data-field="quant[2]"  onclick="editProdRest(this);"><span class="glyphicon glyphicon-pencil"></span> </button></div></td>'
             +'<td><span class="product"><strong>'+nomProd+'</strong></span>'
             +'<input name="nomProd" type="hidden" value="'+nomProd+'"/></td>'
             +'<td><span class="product">'+precio+'<span class="glyphicon glyphicon-euro"></span></span>'
             +'<input name="price" type="hidden" value="'+precio+'"/></td>'
             +'<td><span class="product">'+ descripcion+'</span>'
             +'<input name="description" type="hidden" value="'+descripcion+'"/></td>');
    $('#nombreItem').val('');
    $('#precioItem').val('');
    $('#descripcionItem').val('');
}

function editProdRest(elem){
	var index = $(elem).parent().parent().parent().index();
	
}

//restaurant
/*{{#restaurants}}
<li class="list-group-item itemListaRest"><a href="/item">
		<!--  <img src="/img/telepizza%20ejemplo.jpg" />--> <img
		src="data:image/jpg;base64,{{image}}" width="150 px"
		height="150 px">
</a>
	<h5 class="nombre-rest">
		<a href="/products/{{id}}">{{name}}</a>
	</h5>
	<p class="direccion">{{address}} <br> {{phone}} , {{email}}</p>
</li> 
{{/restaurants}}*/
function getTenRestaurants(){
	$.ajax({
		url:"/restaurant/?page="+page+"&size=10",
		success:addTenRestaurants
	});
}

function addTenRestaurants(result){
	var content = result["content"];
	for(var i=0;i<content.length;i++){
		$("#restaurantList").append('<li class="list-group-item itemListaRest"><a href="/item">'
				+'<img src="data:image/jpg;base64,'+content[i].image+'" width="150 px"	height="150 px"></a>'
				+'<h5 class="nombre-rest"><a href="/products/{{id}}">'+ content[i].name +'</a></h5>'
				+'<p class="direccion">'+ content[i].address +' <br>'+ content[i].phone +' ,' + content[i].email
				+'</p></li>');
	}
}