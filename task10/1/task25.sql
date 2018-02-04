SELECT DISTINCT marker
FROM Product 
WHERE type = 'printer' AND 
      marker IN(SELECT marker 
               FROM Product 
               WHERE model IN(SELECT model 
                              FROM PC
                              WHERE speed = (SELECT MAX(speed)
                                             FROM (SELECT speed 
                                                   FROM PC 
                                                   WHERE ram=(SELECT MIN(ram)
                                                              FROM PC
                                                              )
                                                   ) AS z4
                                             )
                              )
               );