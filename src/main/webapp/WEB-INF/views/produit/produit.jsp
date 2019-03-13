<%@ include file="/WEB-INF/views/includes/include.jsp" %>

<%@ include file="/WEB-INF/views/menu_left/left.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath()%>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
           <%@ include file="/WEB-INF/views/menu_top/top.jsp" %>
        </nav>

        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key="common.produit" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                      <div class="row">
                <div class="col-lg-12">
                <br />
                <nav aria-label="breadcrumb">
			    <ol class="breadcrumb">
			    <c:url value="/produit/nouveau" var="nouveau" />
			    <c:url value="/produit/export" var="export" />
			     <li class="breadcrumb-item"><a href="${nouveau}"><i class="fa fa-plus"><fmt:message key="common.nouveau" /></i></a></li>
			     <li class="breadcrumb-item"><a href="${export }"><i class="fa fa-download "><fmt:message key="common.export" /></i></a></li>
			     
			    
			
			   </ol>
			</nav>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Produit</th>
                                        <th>Quantite</th>
                                        <th>Actions</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${produits}" var="produit">
                                    <tr class="odd gradeX">
                                        <td>${produit.getNomProduit()}</td>
                                        <td>${produit.getQuantite() }</td>
                                        <td>
                                        <c:url value="/produit/supprimer/${ produit.getIdProduit()}" var="supprimer" />
                                        <c:url value="/produit/modifier/${ produit.getIdProduit()}" var="modifier" />
                                        <div class="col-lg-4"><a href="${supprimer }">Supprimer</a></div>
                                        <div class="col-lg-4"><a href="${modifier }">Modifier</a></div>
                                        </td>
                                        
                                    </tr>
                               </c:forEach>     

                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                         
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
                
            </div>
            <!-- /.container-fluid -->
        </div>
        
        <!-- /#page-wrapper -->

    </div>
    
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
