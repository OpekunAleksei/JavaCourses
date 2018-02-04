SELECT P.model, L.model, P.speed, P.ram
FROM PC P JOIN 
     (SELECT speed, ram
      FROM PC
      GROUP BY speed, ram
      HAVING COUNT(*) = (select count(*) - count(distinct speed,ram)from pc )+1
      ) S ON P.speed = S.speed AND 
             P.ram = S.ram JOIN 
      PC L ON L.speed = S.speed AND 
              L.ram = S.ram AND 
              L.model < P.model;