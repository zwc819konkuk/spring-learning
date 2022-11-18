<%--
  Created by IntelliJ IDEA.
  User: ray
  Date: 2022-11-14
  Time: PM 4:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        #playerTable{
            width: 50%;
            border: 3px solid cadetblue;
            margin: 0 auto;
            text-align: center;
        }
        #playerTable th,td{
            border: 1px solid coral;
        }
        #playerTable img{
            width: 100px;
            height: 100px;
        }
    </style>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $.ajax({
                type:"get",
                url:"getAllPlayer",
                success:function (players) {
                    $.each(players,function (i,e) {
                        $("#playerTable").append("" +
                            "<tr>\n" +
                            "            <td>"+e.id+"</td>\n" +
                            "            <td>"+e.name+"</td>\n" +
                            "            <td>"+e.password+"</td>\n" +
                            "            <td>"+e.nickname+"</td>\n" +
                            "            <td>\n" +
                            "                <img src='http://117.16.136.189:8090/upload/"+e.photo+"' alt='暂未发现图片'>\n" +
                            "            </td>\n" +
                            "            <td>\n" +
                            "                <a href='fileDownload.do?id="+e.photo+'&filetype='+e.filetype+"'>下载</a>\n" +
                            "            </td>\n" +
                            "        </tr>")
                    })
                }
            })
        })
    </script>
</head>
<body>
    <table id="playerTable" cellspacing="0px" cellpadding="0px">
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>昵称</th>
            <th>头像</th>
            <th>操作</th>
        </tr>

    </table>
</body>
</html>
