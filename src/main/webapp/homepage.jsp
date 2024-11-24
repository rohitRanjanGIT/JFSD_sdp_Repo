<%@ include file="header.jsp" %>
<div class="container mt-4">
    <h1 class="text-center">Welcome to the Scholarship Management System</h1>
    <p class="text-center lead">Your one-stop solution to manage scholarships and financial aid applications effectively.</p>

    <div class="row mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Search Scholarships</h5>
                    <p class="card-text">Find the best scholarships that match your profile and apply easily.</p>
                    <a href="/student/scholarships" class="btn btn-primary">View Scholarships</a>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Financial Aid</h5>
                    <p class="card-text">Explore financial aid opportunities and track your applications.</p>
                    <a href="/student/financial-aid" class="btn btn-primary">View Financial Aid</a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp" %>
