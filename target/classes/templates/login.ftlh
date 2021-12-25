<#import "parts/common.ftlh" as p>
<#import "parts/login.ftlh" as l>
<#import "parts/message.ftlh" as m>
<@p.page>
<#if message??>
<@m.errorlist />
</#if>
<div class="fs-3 col-1 mx-auto mb-5">
    <b>LOGIN</b>
</div>
<@l.login "/login" false/>
</@p.page>