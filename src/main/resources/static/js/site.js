/**
 * 当标签出现在脚本代码后面时，不能使用$().click();
 * on()方法绑定事件成之为委托方式绑定，on()也需要标签已经被解析才可以绑定事件
 * 解决方法：调用jQuery得ready函数执行文档加载完成后处理时间绑定
 * @param {type} param
 */
$(function () {
    $("td").on("click", ".delbtn", function () {
        return confirm("确认删除吗？此操作不可恢复");
    });
    var uids={uids:[]};
    $(".cuid").click(function () {
        uids.uids=[];
        $(".cuid:checked").each(function () {   //遍历所有被选择的复选框
            uids.uids.push($(this).val());
        });
    });
    $(".delbtns").click(function () {           //多条信息删除
        if (uids.uids.length<=0) return;
        if (confirm("确认要删除被选择的信息吗？此操作不可恢复")) {
            var json = JSON.stringify(uids);
            console.log("======" + json);
            $("#deleteuids").val(json);
            $("#form1").attr("action", "/deleteusers");
            $("#form1").submit();
        }
    });
});
