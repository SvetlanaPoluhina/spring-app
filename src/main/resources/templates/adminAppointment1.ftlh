<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <div class="loginn">
        <p>Запись на прием</p>

        <form name="form1" action="/adminAppointment1" method="post">

            <div class="vvod">
                <label>
                    Выберите мед.учреждение:
                    <select name="policlinic_app">
                        <option selected value=0 >Выберите адрес</option>
                        <#list places>
                            <#items as policlinic_app>
                                <div class="vvod"><option value="${policlinic_app.idplace}">${policlinic_app.address}</option></div>
                            </#items>
                        </#list>
                    </select>
                </label>
            </div>
            <div class="vvod">
                <label>
                    Выберите услугу:
                    <select name="usluga">
                        <option selected value=0 >Выберите услугу</option>
                        <#list specializations>
                            <#items as usluga>
                                <div class="vvod"><option value="${usluga.id_specialization}">${usluga.name_spec}</option></div>
                            </#items>
                        </#list>
                    </select>
                </label>
            </div>

            <input type="button" value="Далее" onclick="location.href='http://localhost:8080/adminAppointment2/'+escape(document.forms['form1'].elements['policlinic_app'].value)+'/'+escape(document.forms['form1'].elements['usluga'].value)">

            <!--button type="submit">Далее</button-->

        </form>
    </div>

</@c.page>