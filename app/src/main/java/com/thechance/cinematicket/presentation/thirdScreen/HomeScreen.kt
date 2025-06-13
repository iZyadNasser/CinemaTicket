package com.thechance.cinematicket.presentation.thirdScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.cloudy.cloudy
import com.thechance.cinematicket.R
import com.thechance.cinematicket.presentation.ui.theme.mainColor
import kotlin.math.absoluteValue

@Composable
fun HomeScreen(
    uiState: HomeState,
) {
    val pagerState = rememberPagerState { uiState.movies.size }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        BottomBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    bottom = 16.dp
                )
                .navigationBarsPadding()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .blur(500.dp)
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(
                        id = uiState.movies[pagerState.currentPage].posterRes
                    ),
                    contentDescription = uiState.selectedMovie?.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth()
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .padding(
                        top = 44.dp
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clip(RoundedCornerShape(40.dp))
                            .background(Color(0xFFFD5723))
                            .padding(
                                vertical = 12.dp,
                                horizontal = 20.dp
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Now Showing",
                            color = Color.White,
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                        )
                    }

                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(40.dp))
                            .border(
                                width = 1.dp,
                                color = Color.White.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(40.dp)
                            )
                            .padding(
                                vertical = 12.dp,
                                horizontal = 20.dp
                            ),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Coming Soon",
                            color = Color.White,
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier
                        )
                    }
                }

                HorizontalPager(
                    state = pagerState,
                    contentPadding = PaddingValues(
                        horizontal = 24.dp
                    ),
                    pageSize = PageSize.Fixed(
                        pageSize = 250.dp
                    ),
                    pageSpacing = 32.dp,
                    modifier = Modifier.clip(RoundedCornerShape(20.dp))
                ) { index ->
                    val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
                    Image(
                        painter = painterResource(
                            id = uiState.movies[index].posterRes
                        ),
                        contentDescription = uiState.movies[index].name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(
                                width = 270.dp
                            )
                            .height(370.dp)
                            .graphicsLayer {
                                val scaleFactor = 1f - (0.2f * pageOffset.absoluteValue)

                                scaleX = maxOf(0.8f, scaleFactor)
                                scaleY = maxOf(0.8f, scaleFactor)

                                alpha = maxOf(0.5f, scaleFactor)
                            }
                            .clip(RoundedCornerShape(20.dp))
                    )
                }
            }
        }
    }
}

@Composable
private fun BottomBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(mainColor)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_movie),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
            )
        }

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_search),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(32.dp)
        )

        Row {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_ticket),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(32.dp)
            )

            Text(
                text = "5",
                color = Color.White,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(mainColor)
                    .padding(horizontal = 4.dp, vertical = 2.dp)
            )
        }

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_profile),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(32.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(
        uiState = HomeState()
    )
}