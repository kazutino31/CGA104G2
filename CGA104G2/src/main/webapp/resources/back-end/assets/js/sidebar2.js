document.writeln("<div id=\'app\'>");
document.writeln("    <div id=\'sidebar\' class=\'active\' >");
document.writeln("        <div class=\'sidebar-wrapper active\'>");
document.writeln("            <div class=\'sidebar-header position-relative\'>");
document.writeln("                <div class=\'d-flex justify-content-between align-items-center \'>");

document.writeln("                    <div class=\'sidebar-toggler  x\'>");
document.writeln("                        <a href=\'#\' class=\'sidebar-hide d-xl-none d-block\'><i class=\'bi bi-x bi-middle\'></i></a>");
document.writeln("                    </div>");
document.writeln("                </div>");
document.writeln("            </div>");
document.writeln("            <div class=\'logo\'>");
document.writeln("                <a href=\'../../back-end/web/backEndHomeMgr.html\'><img src=\'../../resources/front-end/assets/img/logo11_trans4.png\' alt=\'Logo\' srcset=\'\'");
document.writeln("                                         width=\'80%\'></a>");
document.writeln("            </div>");
document.writeln("            <div class=\'sidebar-menu\'>");
document.writeln("                <ul class=\'menu\'>");
// document.writeln("                     <li class=\'sidebar-title\'></li>");
// document.writeln("");
// document.writeln("                    <li class=\'sidebar-item active \'>");
// document.writeln("                        <a href=\'.\/\/index.html\' class=\'sidebar-link\'>");
// document.writeln("                            <i class=\'bi bi-box-arrow-left\'></i>");
// document.writeln("                            <span>menu</span>");
// document.writeln("                        </a>");
// document.writeln("                    </li>");
document.writeln("");
document.writeln("                    <li class=\'sidebar-item  has-sub\'>");
document.writeln("                        <a href=\'#\' class=\'sidebar-link\'>");
document.writeln("                            <i class=\'bi bi-person-badge-fill\'></i>");
document.writeln("                            <span>住戶資訊</span>");
document.writeln("                        </a>");
document.writeln("                        <ul class=\'submenu \'>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/member/listAllMember.jsp\'>個人資訊</a>");
document.writeln("                            </li>");
document.writeln("");
document.writeln("                        </ul>");
document.writeln("                    </li>");
document.writeln("");
document.writeln("                    <li class=\'sidebar-item\'>");
document.writeln("                        <a href=\'/CGA104G2/back-end/mail/mailIndexBootStrap.html\' class=\'sidebar-link\'>");
document.writeln("                            <i class=\'bi bi-clipboard-check\'></i>");
document.writeln("                            <span>郵件</span>");
document.writeln("                        </a>");
document.writeln("                    </li>");
document.writeln("");
document.writeln("                    <li class=\'sidebar-item has-sub\'>");
document.writeln("                        <a href=\'#\' class=\'sidebar-link\'>");
document.writeln("                            <i class=\'bi bi-calculator\'></i>");
document.writeln("                            <span>社區帳單</span>");
document.writeln("                        </a>");
document.writeln("                        <ul class=\'submenu \'>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'/CGA104G2/member/bill.do?action=getAll\'>帳單管理</a>");
document.writeln("                            </li>");
document.writeln("                        </ul>");
document.writeln("                    </li>");
document.writeln("");
document.writeln("                    <li class=\'sidebar-item  has-sub\'>");
document.writeln("                        <a href=\'#\' class=\'sidebar-link\'>");
document.writeln("                            <i class=\'bi bi-calendar-check-fill\'></i>");
document.writeln("                            <span>公共設施</span>");
document.writeln("                        </a>");
document.writeln("                        <ul class=\'submenu \'>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/ame/addAme.jsp\'>新增公設</a>");
document.writeln("                            </li>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/ame/controlAme.jsp\'>公設管理</a>");
document.writeln("                            </li>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'.html\'>維修公設</a>");
document.writeln("                            </li>");
document.writeln("                        </ul>");
document.writeln("                    </li>");
document.writeln("");
document.writeln("                    <li class=\'sidebar-item  has-sub\'>");
document.writeln("                        <a href=\'#\' class=\'sidebar-link\'>");
document.writeln("                            <i class=\'bi bi-spotify\'></i>");
document.writeln("                            <span>活動</span>");
document.writeln("                        </a>");
document.writeln("                        <ul class=\'submenu\'>");
document.writeln("                            <li class=\'submenu-item\'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/activity/management.html\'>管理活動檢舉</a>");
document.writeln("                            </li>");
document.writeln("                            <li class=\'submenu-item\'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/activity/history.html\'>檢舉紀錄</a>");
document.writeln("                            </li>");
document.writeln("                        </ul>");
document.writeln("                    </li>");
document.writeln("");
document.writeln("                    <li class=\'sidebar-item  has-sub\'>");
document.writeln("                        <a href=\'#\' class=\'sidebar-link\'>");
document.writeln("                            <i class=\'bi bi-tools\'></i>");
document.writeln("                            <span>檢舉與維修服務</span>");
document.writeln("                        </a>");
document.writeln("                        <ul class=\'submenu \'>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'\'>我是子選單名1</a>");
document.writeln("                            </li>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'\'>我是子選單名2</a>");
document.writeln("                            </li>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'\'>我是子選單名3</a>");
document.writeln("                            </li>");
document.writeln("                             </ul>");
document.writeln("                    </li>");
document.writeln("");
document.writeln("                    <li class=\'sidebar-item\'>");
document.writeln("                        <a href=\'/CGA104G2/back-end/store/storeIndexBootStrap.html\' class=\'sidebar-link\'>");
document.writeln("                            <i class=\'bi bi-pin-map-fill\'></i>");
document.writeln("                            <span>特約商店</span>");
document.writeln("                        </a>");
document.writeln("                    </li>");
document.writeln("");
document.writeln("                    <li class=\'sidebar-item has-sub\'>");
document.writeln("                        <a href=\'.html\' class=\'sidebar-link\'>");
document.writeln("                            <i class=\'bi bi-file-earmark-medical-fill\'></i>");
document.writeln("                            <span>管理員帳號與權限</span>");
document.writeln("                        </a>");
document.writeln("                        <ul class=\'submenu \'>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/backstageAccount/listOneInfo.jsp\'>我的資訊</a>");
document.writeln("                            </li>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/backstageAccount/listAllInfo.jsp\'>所有管理員資訊</a>");
document.writeln("                            </li>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/backstageAuthorization/listOneAuthorization.jsp\'>我的權限</a>");
document.writeln("                            </li>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/backstageAuthorization/listAllAuthorization.jsp\'>所有管理員權限功能</a>");
document.writeln("                            </li>");
document.writeln("                            <li class=\'submenu-item \'>");
document.writeln("                                <a href=\'/CGA104G2/back-end/backstageCapabilities/listAllCapabilities.jsp\'>權限功能列表</a>");
document.writeln("                            </li>");
document.writeln("                             </ul>");
document.writeln("                    </li>");
document.writeln("");
document.writeln("                </ul>");
document.writeln("            </div>");
document.writeln("        </div>");
document.writeln("        </div>");