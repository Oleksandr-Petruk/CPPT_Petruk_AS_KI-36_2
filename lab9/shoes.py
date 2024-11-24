class Shoes:
    """
    Абстрактний клас Shoes, що описує основні характеристики та функціональність взуття.
    """

    def __init__(self, brand, size, color):
        """
        Конструктор для створення взуття.

        :param brand: Бренд взуття.
        :param size: Розмір взуття.
        :param color: Колір взуття.
        """
        self.brand = brand
        self.size = size
        self.color = color
        self.laced = False
        self.worn = False
        self.distance_run = 0.0

    def needs_repair(self):
        """
        Перевіряє, чи потрібно ремонтувати взуття.

        :return: True, якщо пробіг >= 100 км.
        """
        return self.distance_run >= 100

    def add_distance(self, distance):
        """
        Додає дистанцію до загального пробігу.

        :param distance: Пробіг (км).
        """
        self.distance_run += distance

    # Геттери та сеттери для атрибутів класу

    def get_brand(self):
        return self.brand

    def get_size(self):
        return self.size

    def get_color(self):
        return self.color

    def is_laced(self):
        return self.laced

    def set_laced(self, laced):
        self.laced = laced

    def is_worn(self):
        return self.worn

    def set_worn(self, worn):
        self.worn = worn

    def get_distance_run(self):
        return self.distance_run

