from sneakers import Sneakers


def main():
    """
    Точка входу програми.
    """
    sneakers = Sneakers("Nike", 42.5, "Білий")

    while True:
        print("\nОберіть дію:")

        if not sneakers.is_worn():
            print("1. Одягнути взуття")
        else:
            print("1. Зняти взуття")

        if not sneakers.is_laced():
            print("2. Зав'язати шнурки")
        else:
            print("2. Розв'язати шнурки")

        print("3. Очистити взуття")
        print("4. Відремонтувати взуття")
        print("5. Відполірувати взуття")
        print("6. Перевірити стан взуття")
        print("7. Пробігти")
        print("8. Вийти")

        choice = input("Ваш вибір: ")

        if choice == "1":
            if not sneakers.is_worn():
                sneakers.wear()
            else:
                sneakers.remove()
        elif choice == "2":
            if not sneakers.is_laced():
                sneakers.lace_up()
            else:
                sneakers.unlace()
        elif choice == "3":
            sneakers.clean()
        elif choice == "4":
            sneakers.repair()
        elif choice == "5":
            sneakers.polish()
        elif choice == "6":
            sneakers.check_status()
        elif choice == "7":
            if sneakers.is_worn():
                try:
                    distance = float(input("Введіть відстань для пробігу (км): "))
                    sneakers.run(distance)
                except ValueError:
                    print("Помилка: введіть числове значення.")
            else:
                print("Спочатку одягніть взуття.")
        elif choice == "8":
            print("Програма завершена.")
            break
        else:
            print("Невірний вибір, спробуйте ще раз.")


if __name__ == "__main__":
    main()

