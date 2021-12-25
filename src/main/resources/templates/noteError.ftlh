<#import "parts/common.ftlh" as p>
<#import "parts/message.ftlh" as m>
<@p.page>
<#if message??>
<@m.errorlist />
</#if>
<button type="button" class="btn btn-primary m-2" onclick="location.href='/note/list'">Return to note's list</button>
</@p.page>