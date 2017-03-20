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
    if(userType==="user"){
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