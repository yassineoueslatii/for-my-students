<%@ include file="/WEB-INF/views/includes/include.jsp" %>
<div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                        <c:url value="/home/" var="home" />
                            <a href="${home}"><i class="fa fa-dashboard fa-fw"></i><fmt:message key="common.home" /> </a>
                        </li>
                        <li>
                        <c:url value="/produit/" var="produit" />
                            <a href="${produit}"><i class="fa fa-dashboard fa-fw"></i><fmt:message key="common.produit" /> </a>
                        </li>
                       
                       
                        <li>
                        <c:url value="/commandev" var="commande" />
                            <a href="${commande}"><i class="fa fa-table fa-fw"></i><fmt:message key="common.command" /></a>
                        </li>
                        <                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>