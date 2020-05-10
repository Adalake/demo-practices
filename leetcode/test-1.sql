SELECT class FROM

(SELECT class, COUNT(DISTINCT student) AS sum FROM courses GROUP BY class) AS temp_table

WHERE sum >= 5;