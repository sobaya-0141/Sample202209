package sobaya.lib.randomdog.drag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun DragAndDropScreenRoute(
    modifier: Modifier = Modifier
) {
    DragAndDropScreen(modifier)
}

@Composable
private fun DragAndDropScreen(
    modifier: Modifier = Modifier
) {
    LongPressDraggable(modifier = modifier.fillMaxSize()) {
        Column{
            DragItemList()
            DropItemList()
        }
    }
}

@Composable
private fun DropItemList(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.3f)
    ) {
        items(
            items = (0..2).map { it },
            key = { num -> num }
        ) {
            DropItemCard()
        }
    }
}

@Composable
private fun DragItemList(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.7f),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 16.dp
        )
    ) {
        items(
            items = (0..2).map { it },
            key = { num -> num }
        ) { num ->
            DragItemCard()
        }
    }
}

@Composable
private fun DropItemCard(
    modifier: Modifier = Modifier
) {
    DropTarget<String>(
        modifier = Modifier
            .padding(6.dp)
            .width(width = 120.dp)
            .fillMaxHeight(0.8f)
    ) { isInBound, id ->
        val bgColor = if (isInBound) {
            Color.Red
        } else {
            Color.White
        }
        Card(
            modifier = modifier.background(color = bgColor),
        ) {
            Column(
                modifier = modifier.background(color = bgColor)
            ) {
                AsyncImage(
                    model = "https://avatars.githubusercontent.com/u/45986582?v=4",
                    contentDescription = null,
                    modifier = Modifier.width(120.dp)
                )
            }
        }
    }
}

@Composable
private fun DragItemCard(
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            DragTarget(modifier = Modifier, dataToDrop = "aaa") {
                AsyncImage(
                    model = "https://user-images.githubusercontent.com/45986582/202165736-febbbe22-fc26-4977-a265-4e5703888c8a.jpg",
                    contentDescription = null,
                    modifier = Modifier.width(100.dp)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "新バージョン")
        }
    }
}