<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/subject/edit">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>报表信息</h5>
                    </div>
                    <div class="ibox-content">
                        <input type="hidden" id="subjectId" name="subjectId" value="${subject.subjectId}">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">报表编码:</label>
                            <div class="col-sm-10">
                                <input id="subjectNo" name="subjectNo" class="form-control" type="text"
                                       value="${subject.subjectNo}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">报表名称：</label>
                            <div class="col-sm-10">
                                <input id="subjectName" name="subjectName" class="form-control" type="text"
                                       value="${subject.subjectName}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">报表版本：</label>
                            <div class="col-sm-10">
                                <input id="reportVersion" name="reportVersion" class="form-control" type="text"
                                       value="${subject.reportVersion}">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">序号：</label>
                            <div class="col-sm-10">
                                <input id="sortNo" name="sortNo" class="form-control" type="text"
                                       value="${subject.sortNo}">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-2 control-label">sql：</label>
                            <div class="col-sm-10">
                                <textarea id="reportSql" name="reportSql" class="form-control" rows="10" value="${subject.reportSql}">${subject.reportSql}</textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">备注：</label>
                            <div class="col-sm-10">
                                <textarea id="reportRemark" name="reportRemark" class="form-control" type="text"
                                          value="${subject.reportRemark}"></textarea>
                            </div>
                        </div>


                        <div class="form-group">
                            <div class="col-sm-8 col-sm-offset-3">
                                <button class="btn btn-primary" type="submit">提交</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </form>

</div>


<!-- 全局js -->
<script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
<script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>

<!-- jQuery Validation plugin javascript-->
<script src="${ctx!}/assets/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${ctx!}/assets/js/plugins/validate/messages_zh.min.js"></script>
<script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>
<script src="${ctx!}/assets/js/plugins/layer/laydate/laydate.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        //外部js调用
        laydate({
            elem: '#birthday', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });

        $("#frm").validate({
            rules: {
                username: {
                    required: true,
                },
                password: {
                    required: true,
                    minlength: 6
                }
            },
            messages: {},
            submitHandler: function (form) {
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "${ctx!}/admin/subject/edit",
                    data: $(form).serialize(),
                    success: function (msg) {
                        layer.msg(msg.message, {time: 2000}, function () {
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index);
                        });
                    }
                });
            }
        });
    });
</script>

</body>

</html>
