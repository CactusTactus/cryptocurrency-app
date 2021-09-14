package com.example.cryptocurrencyapp.presentation.coindetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cryptocurrencyapp.domain.model.TeamMember
import com.example.cryptocurrencyapp.presentation.coindetail.components.CoinDetailViewModel
import com.example.cryptocurrencyapp.presentation.coindetail.components.CoinTag
import com.example.cryptocurrencyapp.presentation.coindetail.components.CoinTeamListItem
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        state.coinDetail?.let { coinDetail ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "${coinDetail.rank}. ${coinDetail.name} (${coinDetail.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8F),
                        )
                        Text(
                            text = if (coinDetail.isActive) "Active" else "Inactive",
                            color = if (coinDetail.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2F)
                        )
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp),
                    )
                    Text(
                        text = coinDetail.description,
                        style = MaterialTheme.typography.body2,
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp),
                    )
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3,
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp),
                    )
                    FlowRow(
                        mainAxisSpacing = 8.dp,
                        crossAxisSpacing = 8.dp,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        coinDetail.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp),
                    )
                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.h3,
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp),
                    )
                }
                items(coinDetail.teamMembers) { teamMember ->
                    CoinTeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Divider()
                }
            }
        }

        if (state.errorMessage.isNotBlank()) {
            Text(
                text = state.errorMessage,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}