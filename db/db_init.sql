CREATE TABLE `Books` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT,
  `title` TEXT NOT NULL,
  `author` TEXT NOT NULL,
  `price` REAL NOT NULL,
  `publish_date` DATE,
  `description` TEXT
);

CREATE TABLE `Users` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT,
  `username` TEXT NOT NULL UNIQUE,
  `password` TEXT NOT NULL,
  `email` TEXT NOT NULL,
  `phone_number` TEXT,
  `address` TEXT
);

CREATE TABLE `Shopping_Cart` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT,
  `user_id` INTEGER NOT NULL,
  `book_id` INTEGER NOT NULL,
  `quantity` INTEGER NOT NULL,
  FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`),
  FOREIGN KEY (`book_id`) REFERENCES `Books` (`id`)
);

CREATE TABLE `Orders` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT,
  `user_id` INTEGER NOT NULL,
  `order_date` DATETIME NOT NULL,
  `total_price` NUMERIC(10,2) NOT NULL,
  `status` INTEGER UNSIGNED NOT NULL,
  FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`)
);

CREATE TABLE `Order_Items` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT,
  `order_id` INTEGER NOT NULL,
  `book_id` INTEGER NOT NULL,
  `quantity` INTEGER NOT NULL,
  `price` NUMERIC(10,2) NOT NULL,
  FOREIGN KEY (`order_id`) REFERENCES `Orders` (`id`),
  FOREIGN KEY (`book_id`) REFERENCES `Books` (`id`)
);

CREATE TABLE `Sales_Records` (
  `id` INTEGER PRIMARY KEY AUTOINCREMENT,
  `user_id` INTEGER NOT NULL,
  `book_id` INTEGER NOT NULL,
  `quantity` INTEGER NOT NULL,
  `price` NUMERIC(10,2) NOT NULL,
  `date` DATE NOT NULL,
  FOREIGN KEY (`user_id`) REFERENCES `Users` (`id`),
  FOREIGN KEY (`book_id`) REFERENCES `Books` (`id`)
);


INSERT INTO `Users` (`username`, `password`, `email`, `phone_number`, `address`) VALUES ('admin', 'admin', 'admin@admin', '123456789', 'admin');

INSERT INTO `Books` (`title`, `author`, `price`, `publish_date`, `description`) VALUES ('Java', 'David', '100', '2022-01-01', 'Java is a programming language');