<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="greeting">
        <h>Добро пожаловать в Вашу Электронную Медицинскую Карту!</h>
        <p>Получайте информацию о состоянии своего здоровья не выходя лишний раз из дома.</p>
        <form action="/login">
            <button>Войти</button>
        </form>
        <form action="/registration">
            <button>Зарегистрироваться</button>
        </form>
    </div>
</@c.page>