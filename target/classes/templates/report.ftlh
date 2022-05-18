<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <div class="loginn">
        <p>Добавление заключения</p>

        <form action="/report" method="post">
            <div class="vvod">
                <label>
                    Пациент:
                    <input type="text" name="patient_rep" list="users" placeholder="Выберите пользователя"/>
                    <datalist id="users">
                        <#list users>
                            <#items as patient_rep>
                                <div class="vvod"><option value="${patient_rep.id}">${patient_rep.policy_number}</option></div>
                            </#items>
                        </#list>
                    </datalist>
                </label>
            </div>
            <div class="vvod">
                <label>
                    Диагноз(ы):
                    <a href="">Справочник диагнозов</a>
                    <input type="text" name="diagnoses" list="diagnosees" placeholder="Выберите диагноз"/>
                    <datalist id="diagnosees">
                        <#list diagnosees>
                            <#items as diagnoses>
                                <div class="vvod"><option value="${diagnoses.name_diag}"></option></div>
                            </#items>
                        </#list>
                    </datalist>
                    <div id="input0"></div>
                    <div class="add" onclick="addInputDiagnoses()">+</div>
                </label>
            </div>
            <div class="vvod"><label>Жалобы: <input type="text" name="complaint" /></label></div>
            <div class="vvod">
                <label>
                    Направление на исследование(я):
                    <input type="text" name="researches" list="researchees" placeholder="Выберите исследование"/>
                    <datalist id="researchees">
                        <#list researchees>
                            <#items as researches>
                                <div class="vvod"><option value="${researches.name_research}"></option></div>
                            </#items>
                        </#list>
                    </datalist>
                    <div id="vvod0"></div>
                    <div class="add" onclick="addInputResearches()">+</div>
                </label>
            </div>
            <div class="vvod">
                <label>Рекомендации по лечению:
                    <a href="">Справочник лекарственных средств</a>
                    <input type="text" name="treatment" />
                </label>
            </div>
            <div class="vvod">
                    <label>
                        Заключение:
                        <select name="status_report">
                            <option selected value=0 >Выберите заключение</option>
                            <#list statuses>
                                <#items as status>
                                    <div class="vvod"><option value="${status.id_status_report}">${status.status}</option></div>
                                </#items>
                            </#list>
                        </select>
                    </label>
                <label>Дата повторного приема: <input type="date" name="date_repeated_admission" /></label></div>

            <div class="vvod"><label>Дата: <input type="date" name="date_report" /></label></div>
            <div class="vvod">
                <label>
                    Адрес больницы:
                    <select name="policlinic_rep">
                        <option selected value=0 >Выберите адрес</option>
                        <#list places>
                            <#items as place>
                                <div class="vvod"><option value="${place.idplace}">${place.address}</option></div>
                            </#items>
                        </#list>
                    </select>
                </label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Сохранить</button>
        </form>
        <a href="#" onclick="history.back();return false;">Вернуться назад</a>
    </div>

    <script>
        var x = 0;

        function addInputDiagnoses() {
            if (x < 10) {
                var str = '<input type="text" name="diagnoses" list="diagnosees" placeholder="Выберите диагноз"/> <div id="input' + (x + 1) + '"></div>';
                document.getElementById('input' + x).innerHTML = str;
                x++;
            } else
            {
                alert('Превышено количество добавляемых полей!');
            }
        }
        var y = 0;

        function addInputResearches() {
            if (y < 10) {
                var str = '<input type="text" name="researches" list="researchees" placeholder="Выберите исследование"/> <div id="vvod' + (y + 1) + '"></div>';
                document.getElementById('vvod' + y).innerHTML = str;
                y++;
            } else
            {
                alert('Превышено количество добавляемых полей!');
            }
        }
    </script>
</@c.page>