import SwiftUI

struct ContentView: View {
    @StateObject var viewModel: ViewModel = .init()

	var body: some View {
        List {
            ForEach(viewModel.quotesList, id: \.self) { quote in
                VStack {
                    Text(quote.anime)
                        .font(Font.system(size: 16, weight: .black))
                    Text(quote.character)
                        .font(Font.system(size: 14, weight: .medium))
                    Text(quote.quote)
                        .italic()
                }
                .onAppear {
                    if !viewModel.isLoading, quote == viewModel.quotesList[viewModel.quotesList.count - 1] {
                        viewModel.fetchQuotes()
                    }
                }
                
            }
        }
        .onAppear {
            viewModel.fetchQuotes()
        }
	}
        
}
