<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div class="mg-1">Sign up</div>
${message?ifExists}
<@l.login "/registration" true/>
</@c.page>
