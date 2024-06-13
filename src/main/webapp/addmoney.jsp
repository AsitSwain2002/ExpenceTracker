<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/addMoney.css">
    <title>Money Details</title>
</head>
<body>
    <header>
        <nav></nav>
    </header>
    <div class="mainContainer">
        <div class="inBox">
            <div class="addMoney">
                <form action="addMoney" method="post">
                <input type="text" name="moneyInput" class="moneyInput" placeholder="Enter Money">
                <input type="submit" value="Add" class="add">
            </form>
            </div>
            <form action="expence" method="post">
            <div class="Content">   
                <div class="ContentInput1">
                    <input type="date" name="date" placeholder="Date" class="contentSearch1">
                </div>
                <div class="ContentInput2">
                    <input type="text" name="expenseName" placeholder="Expence.." class="contentSearch2">
                </div>
                <div class="ContentInput3">
                    <input type="tel" name="price" placeholder="Price" class="contentSearch3">
                </div>
            </div>
            <div class="ContentInput4">
                <input type="submit" name="submit" class="contentSearch4">
            </div>
        </form>
        </div>
    </div>
    <!-- <script src="script.js"></script> -->
</body>
</html>