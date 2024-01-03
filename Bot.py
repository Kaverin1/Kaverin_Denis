import re

def get_user_data():
    # Запитати ім'я користувача
    name = input("Введіть ваше ім'я: ")

    # Запитати email
    while True:
        email = input("Введіть ваш email: ")
        if re.match(r"[^@]+@[^@]+\.[^@]+", email):
            break
        else:
            print("Введіть коректний email.")

    # Запитати номер телефону
    while True:
        phone_number = input("Введіть ваш номер телефону: ")
        if re.match(r"\d{10}", phone_number):
            break
        else:
            print("Введіть коректний номер телефону (10 цифр без пробілів та інших символів).")

    # Запитати адресу
    address = input("Введіть вашу адресу: ")

    # Вивести отримані дані
    print("Ваші дані:")
    print("Ім'я:", name)
    print("Email:", email)
    print("Номер телефону:", phone_number)
    print("Адреса:", address)

# Викликати функцію для отримання даних від користувача
get_user_data()
перейти за посиланням для тех підтримки
import webbrowser

url = "https://t.me/Den4kav"

# Відкрити посилання в браузері
webbrowser.open(url)
class ZayavaNaZaminuLichylnyka:
    def __init__(self):
        self.name = None
        self.email = None
        self.phone_number = None
        self.address = None

    def get_user_input(self):
        self.name = input("Введіть ваше ім'я: ")
        self.email = input("Введіть ваш email: ")
        self.phone_number = input("Введіть ваш номер телефону: ")
        self.address = input("Введіть вашу адресу: ")

    def validate_input(self):
        # Додайте ваші власні перевірки для коректності введення (наприклад, використання регулярних виразів)

    def submit_request(self):
        # Логіка для відправки заявки, наприклад, вивід повідомлення про успішну заявку
        print("Ваша заявка на заміну лічильників успішно відправлена.")
        print("Ім'я:", self.name)
        print("Email:", self.email)
        print("Номер телефону:", self.phone_number)
        print("Адреса:", self.address)

# Створити екземпляр класу та виконати процес заявки
zayava = ZayavaNaZaminuLichylnyka()
zayava.get_user_input()
zayava.validate_input()
zayava.submit_request()
import tkinter as tk
import webbrowser
from telegram import Update
from telegram.ext import Updater, CommandHandler, MessageHandler, Filters, CallbackContext

def handle_text(update: Update, context: CallbackContext) -> None:
    user_text = update.message.text
    
     Базова відповідь
    response_text = "Дякуємо за ваше повідомлення: {}".format(user_text)
    
     Надсилання відповіді користувачеві
    update.message.reply_text(response_text)

    Отримання диспетчера для реєстрації обробників
    dp = updater.dispatcher

    Реєстрація обробника текстових повідомлень
    dp.add_handler(MessageHandler(Filters.text & ~Filters.command, handle_text))

    Запуск бота
    updater.start_polling()

    #Зупинка бота при натисканні Ctrl+C
    updater.idle()

if __name__ == '__main__':
    main()

class TechSupportWindow:
    def __init__(self, master):
        self.master = master
        master.title("Технічна підтримка")

        # Додати кнопку для відкриття веб-браузера
        self.support_button = tk.Button(master, text="Звернутися до технічної підтримки", command=self.open_support_link)
        self.support_button.pack(pady=20)

    def open_support_link(self):
        # Відкрити веб-браузер з посиланням на технічну підтримку
        webbrowser.open("https://t.me/Den4kav")

if __name__ == "__main__":
    root = tk.Tk()
    app = TechSupportWindow(root)
    root.mainloop()
 
