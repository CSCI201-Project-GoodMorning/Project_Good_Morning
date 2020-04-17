<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Email Button Test</title>
	</head>
	<body>
	    <form name="form1" method="GET" ACTION="http://127.0.0.1:8500/">
	        <input type="hidden" name="buttonName">
	        <input type="button" value="Send me an Email" onclick="button1()">
	    </form>
	
	    <script language="JavaScript">
	        <!--
	        function button1()
	        {
	            document.form1.buttonName.value = "yes";
	            form1.submit();
	        } 
	        // --> 
	    </script>
	</body>
</html>