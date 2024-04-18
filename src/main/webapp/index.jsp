<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RFP System</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body {
            font-family: sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f4f8f9;
        }

         .topC{
         border-radus:5px;
         }
        .container {
            background-color: #fff;
            padding: 30px;
            
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            
        }

        .upperside {
            background-color: #cee3fd;
            padding-bottom: 3px;
            height: 100vdh;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);

        }

        .h1 {
            font-size: 16px;
            color: #6a9ef8;
            padding-top: 25px;
            padding-left: 25px;
            padding-right: 134px;
        }

        .h2 {
            font-size: 14px;
            color: #6a9ef8;
            margin-top: 5px;
            padding-bottom: 20px;
            margin-left: 26px;
        }

        .lowerside {
            margin-left: 5px;
        }

        .label1 {
            padding-right: 305px;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            font-weight: 600;
        }

        .label2 {
            padding-right: 280px;
            font-family: 'Segoe UI', Tahoma, Verdana, sans-serif;
            font-weight: 600;
            margin-left: 2px;
        }

        .bottomtext {
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-size: 11px;
            font-weight: 300;
        }

        .bottomcontainer {
            margin-top: 40px;
            margin-left: 139px;
        }

        .b1 {
            margin-top: 20px;
            margin-left: 20px;
        }

        .b2 {
            margin-top: 22px;
            margin-left: 20px;
        }

        .b2text {
            margin-left: 10px;
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-weight: 400;
            font-size: 12px;
        }

        h1 {
            font-size: 20px;
            margin-bottom: 10px;
        }

        p {
            font-size: 16px;
            color: #888;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-size: 16px;
        }

        input[type="email"],
        input[type="password"] {
            width: 91.5%;
            padding: 10px 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 13px;
        }

        .form-group button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .button-15 {
            background-color: #3d8ef8;
            border: 1px solid #0077CC;
            border-radius: 4px;
            box-sizing: border-box;
            color: #FFFFFF;
            cursor: pointer;
            direction: ltr;
            font-family: "SF Pro Text", "SF Pro Icons", "AOS Icons", "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-size: 15px;
            font-weight: 300;
            letter-spacing: -.022em;
            line-height: 1.47059;
            min-width: 30px;
            overflow: visible;
            padding: 4px 151px;
            text-align: center;
            vertical-align: baseline;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
            white-space: nowrap;
        }

        a {
            display: block;
            margin-top: 10px;
            color: #888;
            text-decoration: none;
        }

        a:hover {
            color: #4CAF50;
        }
    </style>
</head>

<body>
    <div class="topC">
        <div class=upperside>
            <h1 class="h1">Welcome to RFP System!</h1>
            <p class="h2">Sign in to continue</p>
        </div>
        <div class="container">
            <div class="lowerside">
                  <form action="controller/login" method="post">
                    <div class="form-group">
                        <label for="email" class="label1">Email</label>
                        <input type="email" id="email" name="email" placeholder="Enter Email" style="color: #b9b9bd;" required>
                    </div>
                    <div class="form-group">
                        <label for="password" class="label2">Password</label>
                        <input type="password" id="password" name="password" placeholder="Enter password"
                            style="color: #b9b9bd; " required>
                    </div>
                    <div>
                        <button type="submit" class="button-15">Log In</button>
                    </div>
                </form>
            </div>
            <div class="b1">
                <a href="controller/vRegisterPage" class="bottomtext"><i class="fa fa-lock"></i> Register as Vendor</a>
            </div>
            <div class="b2">
                <a href="signup.jsp" class="bottomtext"><i class="fa fa-lock"></i> Forgot your password?</a>
            </div>
        </div>
        <div class="bottomcontainer">
            <a href="#" class="b2text"><i class="fa fa-copyright"></i> Copyright RFP <i class="fa fa-heart"
                    style="color:red;"></i> system </a>
        </div>
    </div>
</body>

</html>


      