<%@ include file="/WEB-INF/views/includes/include.jsp" %>

<%@ include file="/WEB-INF/views/menu_left/left.jsp" %>
<html>
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

    <!-- DataTables CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

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
        <div id="app">
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                <br />
                <nav aria-label="breadcrumb">
			    <ol class="breadcrumb">
			    <c:url value="/article/nouveau" var="nouveau" />
			    <c:url value="/article/export" var="export" />
			     <li class="breadcrumb-item"><a href="${nouveau}"><i class="fa fa-plus">Nouveau</i></a></li>
			     <li class="breadcrumb-item"><a href="${export }"><i class="fa fa-download ">Exporter</i></a></li>
			     <li class="breadcrumb-item"><a href="#"><i class="fa fa-upload"><fmt:message key="common.importer" /></i></a></li>
			    
			
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
                                        <th>Date Commande</th>
                                        <th>Totale Commande</th>
                                        <th>Actions</th>
                                        
                                    </tr>
                                </thead>
                                <tbody >
                             
                                    <tr class="odd gradeX" v-for="commande in commandes" >
                                        <td>{{commande.dateCommande}}</td>
                                        <td>{{commande.totaleCommande}}</td>
                                         <td><button class="btn btn-danger btn-block" @click="getLignesCommande(commande)" > Afficher liste de commande</button>	</td>
                                      
                                        
                                        
                                    </tr>
                                    

                                </tbody>
                                
                            </table>
                          
                            <!-- /.table-responsive -->
                            
                           
                        </div>
                        <!-- /.panel-body -->
                    </div>
                         <div class="panel panel-default">
                        <div class="panel-heading">
                            Details Commande:
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example" v-if="detail" >
                                <thead>
                                    <tr>
                                      
                                        <th>Article</th>
                                        <th>Quantité</th>
                                        <th>TVA</th>
                                        <th>Prix unitaire</th>
                                        
                                    </tr>
                                </thead>
                                <tbody >
                               
                                    <tr class="odd gradeX" v-for="ligne in lignes" >
                                        <td>{{ligne.produit.nomProduit}}</td>
                                        <td>{{ligne.quantite}}</td>
                                        <td>{{ligne.tva}}</td>
                                        <td>{{ligne.prixUnitaire}}</td>
                                        
                                        
                                    </tr>
                                    

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
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

   

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/resources/dist/js/sb-admin-2.js"></script>
	<script src="https://unpkg.com/vue@2.0.3/dist/vue.js"></script>
	<script src="https://unpkg.com/axios@0.12.0/dist/axios.min.js"></script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
<script>
const app = new Vue({
    el: '#app',
    data: {
    	message:'Bonjour Yassine',
    	commandes:[],
    	lignes:[],
    	detail:false
    	
    	},
    methods:{
    	getExperiences: function (){

      		axios.get("http://localhost:8080/mvc/getcommande")

      		.then(response=>{
      			this.commandes=response.data;
      			console.log(response)
      			})
      		.catch(error=>{
      			console.log(error);

      		})


      	},
        getLignesCommande : function (commande){
        	axios.get('http://localhost:8080/mvc/getlignescommande/'+commande.idCommande)
        	.then(response=>{
      			this.lignes=response.data;
      			this.detail=true;
      			
      			console.log(response)
      			
      			})
      		.catch(error=>{
      			console.log(error);

      		})

        }
    },

    mounted:function(){
      	this.getExperiences();
      }
    	
   
    	
    });
</script>
</body>


</body>
</html>
