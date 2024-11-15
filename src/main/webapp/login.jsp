<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#loginForm').submit(function(event) {
                let userId = $('#userId').val();
                let password = $('#password').val();

                if (userId === '' || password === '') {
                    alert('Both fields are required!');
                    event.preventDefault();
                }
            });
        });
    </script>
</head>
<body>
<h2>Login Page</h2>
<form id="loginForm" action="login" method="post">
    <label>User ID:</label><br>
    <input type="text" id="userId" name="userId"><br><br>
    <label>Password:</label><br>
    <input type="password" id="password" name="password"><br><br>
    <button type="submit">Login</button>
</form>
</body>
</html>
