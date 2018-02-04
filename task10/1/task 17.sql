SELECT DISTINCT type, Laptop.model, speed
FROM Laptop, Product
WHERE Product.model = Laptop.model AND
      Laptop.speed < (SELECT MIN(speed) FROM PC);