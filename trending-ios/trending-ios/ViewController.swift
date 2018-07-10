//
//  ViewController.swift
//  trending-ios
//
//  Created by jetbrains on 09/07/2018.
//  Copyright © 2018 ktorio. All rights reserved.
//

import UIKit

import trending

let KUnit = TrendingStdlibUnit()

class ViewController: UIViewController {
    let api = TrendingTrending()

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    @IBAction func clickAction(_ sender: Any) {
        api.top(block: { (result: String) -> TrendingStdlibUnit in
            print(result)
            return KUnit
        }, catch: { (cause) -> TrendingStdlibUnit in
            print(cause)
            cause.printStackTrace()
            return KUnit
        })
    }
}
