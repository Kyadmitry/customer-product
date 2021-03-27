<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Register, please!
    </div>
    <br>
    <form method="post" action="/signUp">
        <label for="login">Login
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <br>
        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <br>
        <label for="first-name">Firstname
            <input class="input-field"  id="firstname" name="firstname">
        </label>
        <br>
        <label for="last-name">Lastname
            <input class="input-field"  id="lastname" name="lastname">
        </label>
        <br>
        <br>
        <input type="submit" value="Sign up">
        <br>
    </form>
</div>
</body>
</html>
