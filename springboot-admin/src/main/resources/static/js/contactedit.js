/**
 * 
 */

 document.getElementById('updateButton').addEventListener('click', function(event) {
    event.preventDefault();
    if (confirm('更新しますか？')) {
        // 更新処理をここに追加
        alert('更新されました');
    }
});

document.getElementById('deleteButton').addEventListener('click', function(event) {
    event.preventDefault();
    if (confirm('削除しますか？')) {
        // 削除処理をここに追加
        alert('削除されました');
    }
});