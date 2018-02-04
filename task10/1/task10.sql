select model,price from printer where price=(select price from printer order by price desc limit 1); 
