<%--
  Created by IntelliJ IDEA.
  User: Giorgi Maisuradze
  Date: 3/24/2021
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BTU Java - Giorgi Maisuradze</title>
    <style>
        .form-content{
            text-align: center;
            margin: 0 auto;
            width: 300px;
        }

        .form-group {
            width: 100%;
        }

        .form-group label{
            display: block;
            text-align: start;
            padding: 3px 0 3px 1px;
        }

        .form-group input, .form-group select{
            width: 100%;
            padding: 5px 7px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit]{
            margin-top: 6px;
            border: none;
            background-color: tomato;
            color: white;
            border-radius: 4px;
            padding: 8px 12px;
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="form-content">
    <h1>Form</h1>
    <form method="POST" action="animal">
        <div class="form-group">
            <label for="name">სახელი</label>
            <input type="text" id="name" name="name"/>
        </div>
        <div class="form-group">
            <label for="breed">ჯიში</label>
            <input type="text" id="breed" name="breed"/>
        </div>
        <div class="form-group">
            <label for="gender">სქესი</label>
            <select name="gender" id="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
            </select>
        </div>
        <div class="form-group">
            <label for="age">ასაკი</label>
            <input type="number" id="age" name="age"/>
        </div>
        <input type="submit" value="რეგისტრაცია" />
    </form>
</div>
</body>
</html>
