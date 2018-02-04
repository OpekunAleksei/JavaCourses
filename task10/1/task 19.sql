
select product.marker ,Avg(screen) from laptop,product where product.model=laptop.model group by product.marker;
