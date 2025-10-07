<%@taglib uri="/WEB-INF/mytagss.tld" prefix="shoiabstags" %>

${myobjrequest}....:....${myobjrequest2}
From session...:<%=session.getAttribute("myobj") %>
<h1>Welcome page...</h1>

<shoiabstags:checkNumber num="<%=(String)request.getAttribute(\"number\")%>"/>

