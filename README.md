# SpringCRUD

### API FORMAT 
    {
        "status": <success or failure>, 
        "message": <message from API>, 
        "data": <Requested data if exists>
    }
### API Endpoints

    1. /books                GET        Get all list of boooks
    2. /books/{id}           GET        get book details by ID
    3. /books/addBook        POST       add new book
    4. /books/{id}           PUT        edit book, edit title or total book count in archive
    5. /books/{id}           DELETE     delete book
    6. /transactions/        GET        get all transaction list
    7. /transactions/{id}    GET        get details of a transaction using id
    8. /transactions/        POST       init a transaction type: RETURN or BORROW
    