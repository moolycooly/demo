## Инструкция по запуску
1. Клонируйте репозиторий
2. В терминале введите ```docker-compose up --build```(Нужен Docker).
3. Отправьте POST запрос в формате json на http://localhost:8080, например через PostMan:
```json
{
    "text": "Слова для перевода",
    "source": "ru",
    "target": "en"
}
```
