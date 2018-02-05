SELECT 
    marker
FROM
    pc
        JOIN
    product ON pc.model = product.model
WHERE
    pc.speed >= 750
        AND marker IN (SELECT 
            marker
        FROM
            laptop
                JOIN
            product ON laptop.model = product.model
        WHERE
            laptop.speed >= 750);