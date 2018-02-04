SELECT  model 
FROM (SELECT  model, price 
      FROM PC
      WHERE price = (SELECT MAX(price) 
                     FROM PC
                     )
                     UNION
      SELECT  model,  price 
      FROM Printer
      WHERE price = (SELECT MAX(price) 
                     FROM Printer
                     )
      union
      SELECT  model,  price 
      FROM Laptop
      WHERE price = (SELECT MAX(price) 
                     FROM Laptop
                     )
      

      ) as prices having max(price) 
               ;