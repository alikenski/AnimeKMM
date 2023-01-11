//
//  ViewModel.swift
//  AnimeIOS
//
//  Created by Alisher Aidarkhan on 11.01.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import Shared

class ViewModel: ObservableObject {
    @Published var quotesList: [QuoteModel] = []
    private let networkService = NetworkService()
    private var page: Int32 = 1
    var isLoading = false
    
    func fetchQuotes() {
        isLoading = true
        networkService.getQuotes(page: page) { [weak self] data, err in
            if err == nil, let array = data {
                self?.quotesList += array
                self?.page += 1
            }
            self?.isLoading = false
        }
    }
}
