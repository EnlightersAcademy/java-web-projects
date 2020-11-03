<%@page import="java.util.Date, java.text.DateFormat, java.text.SimpleDateFormat"%>

<%
	DateFormat df = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
	Date dateobj = new Date();
	String currentDate = df.format(dateobj);
%>


</div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                        	<div>
                            </div>
                            <div class="text-muted">Copyright &copy; Espresso Café</div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="assets/vendor/jquery/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="assets/dashboard/js/scripts.js"></script>
    </body>
</html>
