<%@include file="includes/header.jsp" %>
<section>
    <p>Thank you for your patronage of the Golden Oaks Library. You've
        successfully checked out the book, ${checkout.bookTitle}. Please note
        that this book is due back on ${checkout.formattedDate}. A friendly
        email reminder will be sent to you if your book becomes overdue.</p>

    <p><a href="index.jsp">Return to front page</a></p>
</section>
</body>
</html>
