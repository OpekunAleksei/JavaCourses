select  avg(price) from (select price from pc,product where pc.model=product.model and product.marker='nokia')as a;
