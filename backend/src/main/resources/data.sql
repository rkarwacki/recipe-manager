INSERT INTO recipe_category (id, category_name) VALUES
  (-1, 'Śniadanie'),
  (-2, 'Obiad'),
  (-3, 'Kolacja');

INSERT INTO recipe (id, recipe_name, kcal, recipe_category_id) VALUES
  (-1, 'Spaghetti z soczewicą i pieczarkami', 650, -2),
  (-2, 'Ciecierzyca w pomidorach', 773, -2),
  (-3, 'Owsianka z malinami', 230, -1),
  (-4, 'Jajecznica', 320, -1),
  (-5, 'Ziemniaki z koperkiem', 570, -3);