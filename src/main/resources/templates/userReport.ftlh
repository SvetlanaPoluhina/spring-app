<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu.ftlh">

    <div>
        <p>Мои заключения</p>
        <!--form action="/userAnalysis/${currentUserId}"-->
            <div class="div-main-table">
                <div class="div-str-table"><p>Дата</p></div>
                <div class="div-str-table"><p>Специалист</p></div>
                <div class="div-str-table"><p>Заключение</p></div>
            </div>
            <#list reports>
                <#items as report>
                    <div class="div-main-table">
                        <div class="div-str-table">${report.date_report}</div>
                        <div class="div-str-table">${report.doctor_repName}</div>
                        <div class="div-str-table"> <a href="/report/${report.id_med_report}">Перейти к документу</a></div>
                    </div>

                </#items>
            <#else>
                <p> Список пуст </p>
            </#list>
        <!--/form-->
    </div>
</@c.page>