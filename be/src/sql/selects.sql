SELECT *
FROM users u JOIN
       (
         SELECT *
         FROM users
         GROUP BY last_name
         HAVING COUNT(*) > 1
       ) X on X.last_name = u.last_name and X.id != u.id;

use backend;
SELECT *
FROM users u JOIN
       (
         SELECT *
         FROM users
         GROUP BY last_name
         HAVING COUNT(*) > 1
       ) X on X.last_name = u.last_name;