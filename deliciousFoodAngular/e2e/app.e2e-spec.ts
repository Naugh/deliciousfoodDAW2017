import { DeliciousFoodAngularPage } from './app.po';

describe('delicious-food-angular App', () => {
  let page: DeliciousFoodAngularPage;

  beforeEach(() => {
    page = new DeliciousFoodAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
