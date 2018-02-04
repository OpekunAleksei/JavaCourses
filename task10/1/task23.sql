SELECT DISTINCT t.marker 
FROM Product t 
WHERE (t.model IN (SELECT model 
                   FROM PC 
                   WHERE speed >= 750
                   ) OR 
       t.model IN (SELECT model 
                   FROM Laptop 
                   WHERE speed >= 750
                   )
       ) AND 
       EXISTS (SELECT * 
               FROM Product 
               WHERE Product.marker = t.marker AND 
                     Product.type='PC'
               ) AND 
       EXISTS (SELECT * 
               FROM Product 
               WHERE Product.marker = t.marker AND 
               Product.type='Laptop'
               );