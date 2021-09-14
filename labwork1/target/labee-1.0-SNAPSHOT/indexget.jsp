
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GET</title>
</head>
<body>
<form name="ServletGET" method="get" action="formget">
    Full name of the lessor: <input name="lessorname" />
    <br><br>
    Full name of the tenant <input name="tenantname" />
    <br><br>
    Address: <input name="address" />
    <br><br>
    Area: <input name="area" />
    <br><br>
    Floor: <input type="radio" name="floor" value="first" checked />1st floor
    <input type="radio" name="floor" value="second" />2d floor
    <br><br>
    Lease term:<select name="leaseterm">
    <option>3 month</option>
    <option>1 year</option>
    <option>2 year</option>
    <option>3 year</option>
</select>
    <br><br>
    Additional services:
    <input type="checkbox" name="as" value="hcleaning" checked />House cleaning
    <input type="checkbox" name="as" value="wifi" checked />Wi-fi
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
