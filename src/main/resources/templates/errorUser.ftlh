<#import "parts/common.ftlh" as p>
<#import "parts/message.ftlh" as m>
<@p.page>
<#if message??>
<@m.error />
</#if>
<button type="button" class="btn btn-primary m-2" onclick="location.href='/users/${userId}'">Return to user edit</button>
</@p.page>